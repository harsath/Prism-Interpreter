package prism;

import java.util.ArrayList;
import java.util.List;

public class BlockStatement implements Statement {
        private List<Statement> statements;

        BlockStatement() {
                this.statements = new ArrayList<>();
        }

        public void addStatement(Statement statement) {
                this.statements.add(statement);
        }

        public List<Statement> getStatements() {
                return this.statements;
        }

        public void setStatements(List<Statement> statements) {
                this.statements = statements;
        }
}
