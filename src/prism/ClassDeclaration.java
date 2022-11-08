package prism;

public class ClassDeclaration implements Declaration {
        private String className;
        private ClassBodyDeclaration classBody;

        ClassDeclaration() {

        }

        public void addAttribute(VariableDeclaration attribute) {
                this.classBody.addAttribute(attribute);
        }

        public void addMethod(FunctionDeclaration method) {
                this.classBody.addMethod(method);
        }

        public String getClassName() {
                return this.className;
        }

        public void setClassName(String className) {
                this.className = className;
        }

        public ClassBodyDeclaration getClassBody() {
                return this.classBody;
        }

        public void setClassBody(ClassBodyDeclaration classBody) {
                this.classBody = classBody;
        }

        @Override
        public String toString() {
                String returner = new String();
                returner += "CLASS " + className + "{ \n" + classBody.toString() + "\n}";
                return returner;
        }
}
