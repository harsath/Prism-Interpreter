package prism;

import java.util.List;

public class FunctionCallExpression implements Expression {
        private FunctionParamListExpression functionParam;
        private String functionName;

        FunctionCallExpression() {
                this.functionParam = null;
        }

        public FunctionParamListExpression getFunctionParamList() {
                return functionParam;
        }

        public void setFunctionParamList(FunctionParamListExpression functionParam) {
                this.functionParam = functionParam;
        }

        public String getFunctionName() {
                return functionName;
        }

        public void setFunctionName(String functionName) {
                this.functionName = functionName;
        }
}
