package prism;

public class ForLoopStatement implements Statement {
        private VariableDeclarationStatement initBlock;
        private Expression conditionalBlock;
        private AssignmentStatement updationBlock;
        private BlockStatement statementBlock;

        public ForLoopStatement(VariableDeclarationStatement initBlock, Expression conditionalBlock, AssignmentStatement updationBlock, BlockStatement statementBlock) {
                this.initBlock = initBlock;
                this.conditionalBlock = conditionalBlock;
                this.updationBlock = updationBlock;
                this.statementBlock = statementBlock;
        }

        public BlockStatement getStatementBlock() {
                return this.statementBlock;
        }

        public void setStatementBlock(BlockStatement statementBlock) {
                this.statementBlock = statementBlock;
        }

        public VariableDeclarationStatement getInitBlock() {
                return this.initBlock;
        }

        public void setInitBlock(VariableDeclarationStatement initBlock) {
                this.initBlock = initBlock;
        }

        public Expression getConditionalBlock() {
                return this.conditionalBlock;
        }

        public void setConditionalBlock(Expression conditionalBlock) {
                this.conditionalBlock = conditionalBlock;
        }

        public AssignmentStatement getUpdationBlock() {
                return this.updationBlock;
        }

        public void setUpdationBlock(AssignmentStatement updationBlock) {
                this.updationBlock = updationBlock;
        }

        @Override
        public String toString() {
                String returner = "FOR (";
                returner += initBlock.toString() + " " + conditionalBlock.toString() + " " + updationBlock.toString();
                returner += ") {\n";
                for (Statement stmt : statementBlock.getStatements()) {
                        returner += "\t";
                        returner += stmt.toString();
                        returner += "\n";
                }
                returner += "}";
                return returner;
        }

}
