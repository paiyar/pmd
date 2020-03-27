/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.java.ast;

/**
 * @deprecated Replaced with {@link ASTArrayAllocation} and {@link ASTConstructorCall}
 */
@Deprecated
public class ASTAllocationExpression extends AbstractJavaTypeNode {

    ASTAllocationExpression(int id) {
        super(id);
    }

    @Override
    public Object jjtAccept(JavaParserVisitor visitor, Object data) {
        return visitor.visit(this, data);
    }


    @Override
    public <T> void jjtAccept(SideEffectingVisitor<T> visitor, T data) {
        visitor.visit(this, data);
    }


    /**
     * Returns true if this expression defines a body,
     * which is compiled to an anonymous class. If this
     * method returns false, then {@link #getQualifiedName()}
     * returns {@code null}.
     */
    public boolean isAnonymousClass() {
        if (getNumChildren() > 1) {
            // check the last child
            return getChild(getNumChildren() - 1) instanceof ASTClassOrInterfaceBody;
        }
        return false;
    }


}
