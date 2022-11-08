package prism;

import java.security.KeyStore.Entry.Attribute;
import java.util.ArrayList;
import java.util.List;

public class AttributeDeclaration implements Declaration {
        private List<VariableDeclaration> attributes;

        AttributeDeclaration() {
                this.attributes = new ArrayList<>();
        }

        public void addAttribute(VariableDeclaration attribute) {
                this.attributes.add(attribute);
        }

        public List<VariableDeclaration> getAttributes() {
                return this.attributes;
        }

        public void setAttributes(List<VariableDeclaration> attributes) {
                this.attributes = attributes;
        }

        @Override
        public String toString() {
                String returner = new String();
                for (VariableDeclaration attrs : attributes) {
                        returner += attrs.toString();
                        returner += "\n";
                }
                return returner;
        }
}