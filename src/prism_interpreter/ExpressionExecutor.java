package prism_interpreter;

import java.util.*;

import prism.*;

public class ExpressionExecutor {
	private Map<String, FunctionDeclaration> functionDeclarationSymbolTable;
	private Pair<Map<String, Map<String, FunctionDeclaration>>, Map<String, Map<String, AtomType>>> classSymbolTable;

	public ExpressionExecutor(Map<String, FunctionDeclaration> functionDeclarationSymbolTable,
			Pair<Map<String, Map<String, FunctionDeclaration>>, Map<String, Map<String, AtomType>>> classSymbolTable) {
		this.functionDeclarationSymbolTable = functionDeclarationSymbolTable;
		this.classSymbolTable = classSymbolTable;
	}

	// Paramater takes an Expression and a reference to identifiers in current stack
	// We are passing `globalIdentifiers` everytime we call `executeExpression`
	// because any given statement can modify
	// the global variable so we make sure we get the latest version everytime we
	// execute an expression.
	public Expression executeExpression(Map<String, AtomType> globalIdentifiers,
			Map<String, AtomType> scopeIdentifiers, Expression expression) throws Exception {
		if (expression instanceof FunctionCallExpression) {
			return functionCallExpressionHandler(expression, globalIdentifiers, scopeIdentifiers);
		} else if (expression instanceof UnaryMinusExpression) {
			return relationalExpressionTypeHandler(expression, RelationalExpressionType.UNARYMINUS,
					globalIdentifiers, scopeIdentifiers);
		} else if (expression instanceof NotExpression) {
			return logicalExpressionTypeHandler(expression, LogicalExpressionType.NOT, globalIdentifiers,
					scopeIdentifiers);
		} else if (expression instanceof MultiplicationDivisionExpression) {
			if (((MultiplicationDivisionExpression) expression).isMultiplication()) {
				return relationalExpressionTypeHandler(expression,
						RelationalExpressionType.MULTIPLICATION, globalIdentifiers,
						scopeIdentifiers);
			}
			return relationalExpressionTypeHandler(expression, RelationalExpressionType.DIVISION,
					globalIdentifiers, scopeIdentifiers);
		} else if (expression instanceof AdditionSubtractionExpression) {
			if (((AdditionSubtractionExpression) expression).isAddition()) {
				return relationalExpressionTypeHandler(expression, RelationalExpressionType.ADDITION,
						globalIdentifiers, scopeIdentifiers);
			}
			return relationalExpressionTypeHandler(expression, RelationalExpressionType.SUBTRACTION,
					globalIdentifiers, scopeIdentifiers);
		} else if (expression instanceof EqualityExpression) {
			return relationalExpressionTypeHandler(expression, RelationalExpressionType.EQUALITY,
					globalIdentifiers, scopeIdentifiers);
		} else if (expression instanceof OrExpression) {
			return logicalExpressionTypeHandler(expression, LogicalExpressionType.OR, globalIdentifiers,
					scopeIdentifiers);
		} else if (expression instanceof AndExpression) {
			return logicalExpressionTypeHandler(expression, LogicalExpressionType.AND, globalIdentifiers,
					scopeIdentifiers);
		} else if (expression instanceof GreaterthanExpression) {
			return relationalExpressionTypeHandler(expression, RelationalExpressionType.GREATERTHAN,
					globalIdentifiers, scopeIdentifiers);
		} else if (expression instanceof LessthanExpression) {
			return relationalExpressionTypeHandler(expression, RelationalExpressionType.LESSTHAN,
					globalIdentifiers, scopeIdentifiers);
		} else if (expression instanceof GreaterthanEqExpression) {
			return relationalExpressionTypeHandler(expression, RelationalExpressionType.GREATERTHANEQ,
					globalIdentifiers, scopeIdentifiers);
		} else if (expression instanceof LessthanEqExpression) {
			return relationalExpressionTypeHandler(expression, RelationalExpressionType.LESSTHANEQ,
					globalIdentifiers, scopeIdentifiers);
		} else if (expression instanceof VariableAtomExpression) {
			VariableAtomExpression expr = (VariableAtomExpression) expression;
			return lookupIdentifier(globalIdentifiers, scopeIdentifiers, expr.getId());
		} else if (expression instanceof IntegerAtomExpression) {
			return (IntegerAtomExpression) expression;
		} else if (expression instanceof BooleanAtomExpression) {
			return (BooleanAtomExpression) expression;
		} else if (expression instanceof StringAtomExpression) {
			return (StringAtomExpression) expression;
		} else if (expression instanceof BracketExprExpression) {
			BracketExprExpression expr = (BracketExprExpression) expression;
			return executeExpression(globalIdentifiers, scopeIdentifiers, expr.getExpression());
		} else if (expression instanceof MaxFunctionCallExpression) {
			return relationalExpressionTypeHandler(expression, RelationalExpressionType.MAX,
					globalIdentifiers, scopeIdentifiers);
		} else if (expression instanceof MinFunctionCallExpression) {
			return relationalExpressionTypeHandler(expression, RelationalExpressionType.MIN,
					globalIdentifiers, scopeIdentifiers);
		} else if (expression instanceof PowFunctionCallExpression) {
			return relationalExpressionTypeHandler(expression, RelationalExpressionType.POW,
					globalIdentifiers, scopeIdentifiers);
		} else if (expression instanceof PrintFunctionCallExpression) {
			return printExpressionHandler(expression, globalIdentifiers, scopeIdentifiers);
		} else if (expression instanceof PrintlnFunctionCallExpression) {
			return printlnExpressionHandler(expression, globalIdentifiers, scopeIdentifiers);
		} else if (expression instanceof ObjectRHSExpression) {
			return objectRHSExpressionHandler(expression, globalIdentifiers, scopeIdentifiers);
		} else if (expression instanceof ObjectInvocationExpression) {
			return objectInvocationExpressionHandler(expression, globalIdentifiers, scopeIdentifiers);
		} else {
			throw new RuntimeException("Undefined Expression type");
		}
	}

	private Expression lookupIdentifier(Map<String, AtomType> globalIdentifiers,
			Map<String, AtomType> scopeIdentifiers, String id) throws Exception {
		// Local scope is given high presidence when looking up variables
		if (scopeIdentifiers.containsKey(id)) {
			AtomType atom_value = scopeIdentifiers.get(id);
			return ExecutorHelpers.getAtomExpressionFromAtomType(atom_value,
					"Undefined type on scope variable reference");
		} else if (globalIdentifiers.containsKey(id)) {
			AtomType atom_value = globalIdentifiers.get(id);
			return ExecutorHelpers.getAtomExpressionFromAtomType(atom_value,
					"Undefined type on global variable reference");
		} else {
			throw new RuntimeException("Undefined variable");
		}
	}

	// Prism interpreter only allows relational expression (`>`, `<`, `>=`, `<=`,
	// `==`), numeric computations (`*`, `/`, `+`, `-`) between two
	// IntegerAtomExpression
	private void typeCheckRelationalExpression(Expression lhs, Expression rhs) throws Exception {
		if ((lhs instanceof IntegerAtomExpression) && (rhs instanceof IntegerAtomExpression)) {
			return;
		} else {
			throw new RuntimeException("Relational expressions can be executed between two Ints");
		}
	}

	// Prism interpreter only allows logical expression (`||`, `&&`) between two
	// IntegerAtomExpression
	private void typeCheckLogicalExpression(Expression lhs, Expression rhs) throws Exception {
		if ((lhs instanceof BooleanAtomExpression) && (rhs instanceof BooleanAtomExpression)) {
			return;
		} else {
			throw new RuntimeException("Logical expressions can be executed between two Bools");
		}
	}

	private Expression functionCallExpressionHandler(Expression expr, Map<String, AtomType> globalIdentifiers,
			Map<String, AtomType> scopeIdentifiers) throws Exception {
		// Initialize the call stack with parameter values
		FunctionCallExpression fn_call_expr = (FunctionCallExpression) expr;
		if (!functionDeclarationSymbolTable.containsKey(fn_call_expr.getFunctionName())) {
			throw new RuntimeException("Call to undefined function");
		}
		functionDeclarationSymbolTable.get(fn_call_expr.getFunctionName()).setIsExecuted(true);
		Map<String, AtomType> fn_call_scope_identifiers = new HashMap<>();
		if (fn_call_expr.getFunctionParamList() != null) {
			String function_name = fn_call_expr.getFunctionName();
			List<ParameterDeclaration> fn_decl_params = functionDeclarationSymbolTable.get(function_name)
					.getFunctionParamDecl().getParamList();
			List<Expression> params = fn_call_expr.getFunctionParamList().getParamList();
			if (params.size() != fn_decl_params.size()) {
				throw new RuntimeException("Invalid number of parameters on function call");
			}
			for (int i = 0; i < params.size(); i++) {
				String param_name_in_fn_decl = fn_decl_params.get(i).getId();
				Expression expr_in_fn_call = executeExpression(globalIdentifiers, scopeIdentifiers,
						params.get(i));
				fn_call_scope_identifiers.put(param_name_in_fn_decl,
						ExecutorHelpers.getAtomTypeFromAtomExpression(expr_in_fn_call,
								"Invalid type in function call expression"));
			}
			List<Statement> block_stmt = functionDeclarationSymbolTable.get(function_name).getFunctionBody()
					.getStatements();
			StatementExecutor statementExecutor = new StatementExecutor(functionDeclarationSymbolTable,
					classSymbolTable);
			Pair<AtomType, Boolean[]> ret = statementExecutor.executeStatements(globalIdentifiers,
					fn_call_scope_identifiers, block_stmt);
			return ExecutorHelpers.getAtomExpressionFromAtomType(ret.a,
					"Unsupported type in function call execution");
		} else {
			String function_name = fn_call_expr.getFunctionName();
			List<Statement> block_stmt = functionDeclarationSymbolTable.get(function_name).getFunctionBody()
					.getStatements();
			StatementExecutor statementExecutor = new StatementExecutor(functionDeclarationSymbolTable,
					classSymbolTable);
			Pair<AtomType, Boolean[]> ret = statementExecutor.executeStatements(globalIdentifiers,
					fn_call_scope_identifiers, block_stmt);
			return ExecutorHelpers.getAtomExpressionFromAtomType(ret.a,
					"Unsupported type in function call execution");
		}
	}

	private Expression objectRHSExpressionHandler(Expression expr, Map<String, AtomType> globalIdentifiers,
			Map<String, AtomType> scopeIdentifiers) throws Exception {
		ObjectRHSExpression obj_expr = (ObjectRHSExpression) expr;
		Map<String, AtomType> obj_attributes_init_clone = ExecutorHelpers
				.deepCopyClassAttributes(classSymbolTable.b.get(obj_expr.getId()));
		ObjectAtomExpression obj_atom_expr = new ObjectAtomExpression(obj_expr.getId(),
				obj_attributes_init_clone);
		return obj_atom_expr;
	}

	private Expression objectInvocationExpressionHandler(Expression expr, Map<String, AtomType> globalIdentifiers,
			Map<String, AtomType> scopeIdentifiers) throws Exception {
		// Handling attribute calls
		ObjectInvocationExpression obj_expr = (ObjectInvocationExpression) expr;
		if (!obj_expr.getIs_method()) {
			AtomType obj_identifier = ExecutorHelpers.getAtomTypeFromAtomExpression(
					lookupIdentifier(globalIdentifiers, scopeIdentifiers, obj_expr.getId()),
					"Undefined class type in method attribute invocation");
			if (!(obj_identifier instanceof ObjectType)) {
				throw new RuntimeException(
						"Variable inside object attribute invocation is not of type ObjectType");
			}
			ObjectType obj_identifier_cast = (ObjectType) obj_identifier;
			if (!(obj_identifier_cast.containsAttribute(obj_expr.getMember_Id()))) {
				throw new RuntimeException("No such attribute contains in the object");
			}
			return ExecutorHelpers.getAtomExpressionFromAtomType(
					obj_identifier_cast.getAttribute(obj_expr.getMember_Id()),
					"Invalid atom expression type inside attribute invocation expression");
		}
		// Handling method calls
		AtomType obj_identifier = ExecutorHelpers.getAtomTypeFromAtomExpression(
				lookupIdentifier(globalIdentifiers, scopeIdentifiers, obj_expr.getId()),
				"Undefined class type in object invocation expression");
		if (!(obj_identifier instanceof ObjectType)) {
			throw new RuntimeException("Variable is not of type object.");
		}
		ObjectType obj_identifier_cast = (ObjectType) obj_identifier;
		if (!(classSymbolTable.a.get(obj_identifier_cast.getClassName())
				.containsKey(obj_expr.getMember_Id()))) {
			throw new RuntimeException("No such method function exists in the class");
		}
		FunctionDeclaration method_decl = classSymbolTable.a.get(obj_identifier_cast.getClassName())
				.get(obj_expr.getMember_Id());
		Map<String, AtomType> attributes = obj_identifier_cast.getAttributes();
		if (method_decl.getFunctionParamDecl() != null) {
			List<ParameterDeclaration> method_decl_params = method_decl.getFunctionParamDecl()
					.getParamList();
			List<Expression> call_params = obj_expr.getParam_decl().getParamList();
			if (call_params.size() != method_decl_params.size()) {
				throw new RuntimeException("Invalid number of parameters on method call");
			}
			for (int i = 0; i < call_params.size(); i++) {
				String param_name_in_method_decl = method_decl_params.get(i).getId();
				Expression expr_in_method_call = executeExpression(globalIdentifiers, scopeIdentifiers,
						call_params.get(i));
				// NOTE: We are raising exception without replacing the value or other
				// mitigation methods because
				// replacing the attribute value may lead to type mismatch (Ex: attributes may
				// be of type boolean but parameter may be of type string)
				if (attributes.containsKey(param_name_in_method_decl)) {
					throw new RuntimeException(
							"Parameter name of a method cannot be same as that of an attribute.");
				}
				attributes.put(param_name_in_method_decl, ExecutorHelpers.getAtomTypeFromAtomExpression(
						expr_in_method_call, "Invalid type in method parameter list"));
			}
			List<Statement> block_stmt = method_decl.getFunctionBody().getStatements();
			StatementExecutor statement_executor = new StatementExecutor(functionDeclarationSymbolTable,
					classSymbolTable);
			Pair<AtomType, Boolean[]> ret = statement_executor.executeStatements(globalIdentifiers,
					attributes, block_stmt);
			return ExecutorHelpers.getAtomExpressionFromAtomType(ret.a,
					"Invalid return from statement executor of method call");
		} else {
			List<Statement> block_stmt = method_decl.getFunctionBody().getStatements();
			StatementExecutor statement_executor = new StatementExecutor(functionDeclarationSymbolTable,
					classSymbolTable);
			Pair<AtomType, Boolean[]> ret = statement_executor.executeStatements(globalIdentifiers,
					attributes, block_stmt);
			return ExecutorHelpers.getAtomExpressionFromAtomType(ret.a,
					"Invaild return from statement executor of method call");
		}

	}

	private Expression relationalExpressionTypeHandler(Expression expr, RelationalExpressionType type,
			Map<String, AtomType> globalIdentifiers, Map<String, AtomType> scopeIdentifiers)
			throws Exception {
		Expression lhs, rhs;
		switch (type) {
			case MULTIPLICATION: {
				MultiplicationDivisionExpression expr_cast = (MultiplicationDivisionExpression) expr;
				lhs = executeExpression(globalIdentifiers, scopeIdentifiers, expr_cast.getLeft());
				rhs = executeExpression(globalIdentifiers, scopeIdentifiers, expr_cast.getRight());
				typeCheckRelationalExpression(lhs, rhs);
				IntegerAtomExpression lhs_cast = (IntegerAtomExpression) lhs;
				IntegerAtomExpression rhs_cast = (IntegerAtomExpression) rhs;
				return new IntegerAtomExpression((lhs_cast.getValue() * rhs_cast.getValue()));
			}
			case DIVISION: {
				MultiplicationDivisionExpression expr_cast = (MultiplicationDivisionExpression) expr;
				lhs = executeExpression(globalIdentifiers, scopeIdentifiers, expr_cast.getLeft());
				rhs = executeExpression(globalIdentifiers, scopeIdentifiers, expr_cast.getRight());
				typeCheckRelationalExpression(lhs, rhs);
				IntegerAtomExpression lhs_cast = (IntegerAtomExpression) lhs;
				IntegerAtomExpression rhs_cast = (IntegerAtomExpression) rhs;
				return new IntegerAtomExpression((lhs_cast.getValue() / rhs_cast.getValue()));
			}
			case ADDITION: {
				AdditionSubtractionExpression expr_cast = (AdditionSubtractionExpression) expr;
				lhs = executeExpression(globalIdentifiers, scopeIdentifiers, expr_cast.getLeft());
				rhs = executeExpression(globalIdentifiers, scopeIdentifiers, expr_cast.getRight());
				typeCheckRelationalExpression(lhs, rhs);
				IntegerAtomExpression lhs_cast = (IntegerAtomExpression) lhs;
				IntegerAtomExpression rhs_cast = (IntegerAtomExpression) rhs;
				return new IntegerAtomExpression((lhs_cast.getValue() + rhs_cast.getValue()));
			}
			case SUBTRACTION: {
				AdditionSubtractionExpression expr_cast = (AdditionSubtractionExpression) expr;
				lhs = executeExpression(globalIdentifiers, scopeIdentifiers, expr_cast.getLeft());
				rhs = executeExpression(globalIdentifiers, scopeIdentifiers, expr_cast.getRight());
				typeCheckRelationalExpression(lhs, rhs);
				IntegerAtomExpression lhs_cast = (IntegerAtomExpression) lhs;
				IntegerAtomExpression rhs_cast = (IntegerAtomExpression) rhs;
				return new IntegerAtomExpression((lhs_cast.getValue() - rhs_cast.getValue()));
			}
			case EQUALITY: {
				EqualityExpression expr_cast = (EqualityExpression) expr;
				lhs = executeExpression(globalIdentifiers, scopeIdentifiers, expr_cast.getLeft());
				rhs = executeExpression(globalIdentifiers, scopeIdentifiers, expr_cast.getRight());
				typeCheckRelationalExpression(lhs, rhs);
				IntegerAtomExpression lhs_cast = (IntegerAtomExpression) lhs;
				IntegerAtomExpression rhs_cast = (IntegerAtomExpression) rhs;
				return new BooleanAtomExpression((lhs_cast.getValue() == rhs_cast.getValue()));
			}
			case GREATERTHAN: {
				GreaterthanExpression expr_cast = (GreaterthanExpression) expr;
				lhs = executeExpression(globalIdentifiers, scopeIdentifiers, expr_cast.getLeft());
				rhs = executeExpression(globalIdentifiers, scopeIdentifiers, expr_cast.getRight());
				typeCheckRelationalExpression(lhs, rhs);
				IntegerAtomExpression lhs_cast = (IntegerAtomExpression) lhs;
				IntegerAtomExpression rhs_cast = (IntegerAtomExpression) rhs;
				return new BooleanAtomExpression((lhs_cast.getValue() > rhs_cast.getValue()));
			}
			case LESSTHAN: {
				LessthanExpression expr_cast = (LessthanExpression) expr;
				lhs = executeExpression(globalIdentifiers, scopeIdentifiers, expr_cast.getLeft());
				rhs = executeExpression(globalIdentifiers, scopeIdentifiers, expr_cast.getRight());
				typeCheckRelationalExpression(lhs, rhs);
				IntegerAtomExpression lhs_cast = (IntegerAtomExpression) lhs;
				IntegerAtomExpression rhs_cast = (IntegerAtomExpression) rhs;
				return new BooleanAtomExpression((lhs_cast.getValue() < rhs_cast.getValue()));
			}
			case GREATERTHANEQ: {
				GreaterthanEqExpression expr_cast = (GreaterthanEqExpression) expr;
				lhs = executeExpression(globalIdentifiers, scopeIdentifiers, expr_cast.getLeft());
				rhs = executeExpression(globalIdentifiers, scopeIdentifiers, expr_cast.getRight());
				typeCheckRelationalExpression(lhs, rhs);
				IntegerAtomExpression lhs_cast = (IntegerAtomExpression) lhs;
				IntegerAtomExpression rhs_cast = (IntegerAtomExpression) rhs;
				return new BooleanAtomExpression((lhs_cast.getValue() >= rhs_cast.getValue()));
			}
			case LESSTHANEQ: {
				LessthanEqExpression expr_cast = (LessthanEqExpression) expr;
				lhs = executeExpression(globalIdentifiers, scopeIdentifiers, expr_cast.getLeft());
				rhs = executeExpression(globalIdentifiers, scopeIdentifiers, expr_cast.getRight());
				typeCheckRelationalExpression(lhs, rhs);
				IntegerAtomExpression lhs_cast = (IntegerAtomExpression) lhs;
				IntegerAtomExpression rhs_cast = (IntegerAtomExpression) rhs;
				return new BooleanAtomExpression((lhs_cast.getValue() <= rhs_cast.getValue()));
			}
			case UNARYMINUS: {
				UnaryMinusExpression expr_cast = (UnaryMinusExpression) expr;
				lhs = executeExpression(globalIdentifiers, scopeIdentifiers, expr_cast.getExpression());
				if (!(lhs instanceof IntegerAtomExpression)) {
					throw new RuntimeException(
							"Unary relational expressions can be executed in Int");
				}
				IntegerAtomExpression lhs_cast = (IntegerAtomExpression) lhs;
				return new IntegerAtomExpression((-lhs_cast.getValue()));

			}
			case MAX: {
				MaxFunctionCallExpression expr_cast = (MaxFunctionCallExpression) expr;
				lhs = executeExpression(globalIdentifiers, scopeIdentifiers, expr_cast.getLeft());
				rhs = executeExpression(globalIdentifiers, scopeIdentifiers, expr_cast.getRight());
				typeCheckRelationalExpression(lhs, rhs);
				IntegerAtomExpression lhs_cast = (IntegerAtomExpression) lhs;
				IntegerAtomExpression rhs_cast = (IntegerAtomExpression) rhs;
				return new IntegerAtomExpression(Math.max(lhs_cast.getValue(), rhs_cast.getValue()));
			}
			case MIN: {
				MinFunctionCallExpression expr_cast = (MinFunctionCallExpression) expr;
				lhs = executeExpression(globalIdentifiers, scopeIdentifiers, expr_cast.getLeft());
				rhs = executeExpression(globalIdentifiers, scopeIdentifiers, expr_cast.getRight());
				typeCheckRelationalExpression(lhs, rhs);
				IntegerAtomExpression lhs_cast = (IntegerAtomExpression) lhs;
				IntegerAtomExpression rhs_cast = (IntegerAtomExpression) rhs;
				return new IntegerAtomExpression(Math.min(lhs_cast.getValue(), rhs_cast.getValue()));
			}
			case POW: {
				PowFunctionCallExpression expr_cast = (PowFunctionCallExpression) expr;
				lhs = executeExpression(globalIdentifiers, scopeIdentifiers, expr_cast.getLeft());
				rhs = executeExpression(globalIdentifiers, scopeIdentifiers, expr_cast.getRight());
				typeCheckRelationalExpression(lhs, rhs);
				IntegerAtomExpression lhs_cast = (IntegerAtomExpression) lhs;
				IntegerAtomExpression rhs_cast = (IntegerAtomExpression) rhs;
				return new IntegerAtomExpression(
						(int) Math.pow(lhs_cast.getValue(), rhs_cast.getValue()));
			}
			default:
				throw new Exception("Invalid relational expression");
		}
	}

	private Expression printExpressionHandler(Expression expr, Map<String, AtomType> globalIdentifiers,
			Map<String, AtomType> scopeIdentifiers) throws Exception {

		PrintFunctionCallExpression expr_cast = (PrintFunctionCallExpression) expr;
		Expression print = executeExpression(globalIdentifiers, scopeIdentifiers, expr_cast.getExpr());

		if (print instanceof VariableAtomExpression) { // VARIABLE
			VariableAtomExpression expr_var_cast = (VariableAtomExpression) print;
			String var_id = expr_var_cast.getId();
			System.out.print(var_id);
			return new StringAtomExpression(var_id);
		} else {
			System.out.print(print.toString());
			return new StringAtomExpression(expr_cast.toString());
		}
	}

	private Expression printlnExpressionHandler(Expression expr, Map<String, AtomType> globalIdentifiers,
			Map<String, AtomType> scopeIdentifiers) throws Exception {

		PrintlnFunctionCallExpression expr_cast = (PrintlnFunctionCallExpression) expr;
		Expression print = executeExpression(globalIdentifiers, scopeIdentifiers, expr_cast.getExpr());

		if (print instanceof VariableAtomExpression) { // VARIABLE
			VariableAtomExpression expr_var_cast = (VariableAtomExpression) print;
			String var_id = expr_var_cast.getId();
			System.out.println(var_id);
			return new StringAtomExpression(var_id);
		} else {
			System.out.println(print.toString());
			return new StringAtomExpression(expr_cast.toString());
		}
	}

	private Expression logicalExpressionTypeHandler(Expression expr, LogicalExpressionType type,
			Map<String, AtomType> globalIdentifiers, Map<String, AtomType> scopeIdentifiers)
			throws Exception {
		Expression lhs, rhs;
		switch (type) {
			case OR: {
				OrExpression expr_cast = (OrExpression) expr;
				lhs = executeExpression(globalIdentifiers, scopeIdentifiers, expr_cast.getLeft());
				rhs = executeExpression(globalIdentifiers, scopeIdentifiers, expr_cast.getRight());
				typeCheckLogicalExpression(lhs, rhs);
				BooleanAtomExpression lhs_cast = (BooleanAtomExpression) lhs;
				BooleanAtomExpression rhs_cast = (BooleanAtomExpression) rhs;
				return new BooleanAtomExpression((lhs_cast.getValue() || rhs_cast.getValue()));
			}
			case AND: {
				AndExpression expr_cast = (AndExpression) expr;
				lhs = executeExpression(globalIdentifiers, scopeIdentifiers, expr_cast.getLeft());
				rhs = executeExpression(globalIdentifiers, scopeIdentifiers, expr_cast.getRight());
				typeCheckLogicalExpression(lhs, rhs);
				BooleanAtomExpression lhs_cast = (BooleanAtomExpression) lhs;
				BooleanAtomExpression rhs_cast = (BooleanAtomExpression) rhs;
				return new BooleanAtomExpression((lhs_cast.getValue() && rhs_cast.getValue()));
			}
			case NOT: {
				NotExpression expr_cast = (NotExpression) expr;
				lhs = executeExpression(globalIdentifiers, scopeIdentifiers, expr_cast.getExpression());
				if (!(lhs instanceof BooleanAtomExpression)) {
					throw new RuntimeException(
							"Logical expressions can be executed between two Bools");
				}
				BooleanAtomExpression lhs_cast = (BooleanAtomExpression) lhs;
				return new BooleanAtomExpression((!lhs_cast.getValue()));
			}
			default:
				throw new Exception("Invalid relational expression");

		}
	}

	private enum RelationalExpressionType {
		MULTIPLICATION, DIVISION, ADDITION, SUBTRACTION, EQUALITY, GREATERTHAN, LESSTHAN, GREATERTHANEQ,
		LESSTHANEQ, UNARYMINUS, MAX, MIN, POW
	};

	private enum LogicalExpressionType {
		OR, AND, NOT
	}

}
