package prism;

import antlr.*;
import antlr.PrismParser.*;

public class StatementVisitor extends PrismBaseVisitor<Statement>  {
        private ExpressionVisitor exprVisitor = new ExpressionVisitor();

        @Override
        public Statement visitStmtBlockStmt(StmtBlockStmtContext ctx) {
                BlockStatement block_stmt = new BlockStatement();
                // Empty body
                if (ctx.getChildCount() == 2) {
                        return block_stmt;
                }
                // We don't want to visit '{' and '}'
                //System.out.println("METHOD : " + ctx.getParent().getChild(2).getText());
                // System.out.println("NUM CHILD OF 1st CHILD : " + ctx.getChild(0).getChildCount());
                for (int i = 1; i < ctx.getChildCount() - 1; i++) {
                        Statement stmt = visit(ctx.getChild(i));
                        block_stmt.addStatement(stmt);
                }
                return block_stmt;
        }

        @Override
        public Statement visitBlockStmt(BlockStmtContext ctx) {
                return visit(ctx.getChild(0));
        }

        @Override
        public Statement visitVariableDeclStmt(VariableDeclStmtContext ctx) {
                String var_id = ctx.getChild(0).getChild(1).getText();
                VariableDeclarationStatement var_decl_stmt = new VariableDeclarationStatement(var_id);
                // Variable declaration without initilization
                if (ctx.getChild(0).getChildCount() == 3) {
                        return var_decl_stmt;
                }
                Statement expr = exprVisitor.visit(ctx.getChild(0).getChild(3));
                var_decl_stmt.setExpression((Expression)expr);
                return var_decl_stmt;
        }

        @Override
        public Statement visitIfElseStmt(IfElseStmtContext ctx) {
                IfElseStatement if_else_stmt = new IfElseStatement();
                Statement expr_condition = exprVisitor.visit(ctx.getChild(2));
                Statement if_statement_block = visit(ctx.getChild(4));
                if_else_stmt.setExpr_condition((Expression) expr_condition);
                if_else_stmt.setIf_statement_block(if_statement_block);
                // ELSE statement not defined
                if (ctx.getChildCount() == 5) {
                        return if_else_stmt;
                }
                // ELSE statement defined
                Statement else_statement_block = visit(ctx.getChild(6));
                if_else_stmt.setElse_statement_block(else_statement_block);
                return if_else_stmt;
        }

        @Override
        public Statement visitReturnStmt(ReturnStmtContext ctx) {
                ReturnStatement return_stmt = new ReturnStatement();
                // VOID function. Ex: RETURN;
                if (ctx.getChildCount() == 2) {
                        return return_stmt;
                }
                // RETURN expr;
                Statement expr = exprVisitor.visit(ctx.getChild(1));
                return_stmt.setExpression((Expression)expr);
                return return_stmt;
        }

        @Override
        public Statement visitAssignmentStmt(AssignmentStmtContext ctx) {
                Statement lhs_expr = exprVisitor.visit(ctx.getChild(0));
                Statement rhs_expr = exprVisitor.visit(ctx.getChild(2));
                return new AssignmentStatement((Expression)lhs_expr, (Expression)rhs_expr);
        }

        @Override
        public Statement visitExprStmt(ExprStmtContext ctx) {
                Statement expr = exprVisitor.visit(ctx.getChild(0));
                return new ExpressionStatement((Expression)expr);
        }
}
