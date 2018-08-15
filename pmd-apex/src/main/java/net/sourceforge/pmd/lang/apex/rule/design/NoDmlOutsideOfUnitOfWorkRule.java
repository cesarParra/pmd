package net.sourceforge.pmd.lang.apex.rule.design;

import net.sourceforge.pmd.lang.apex.ast.ASTDmlDeleteStatement;
import net.sourceforge.pmd.lang.apex.ast.ASTDmlInsertStatement;
import net.sourceforge.pmd.lang.apex.ast.ASTDmlMergeStatement;
import net.sourceforge.pmd.lang.apex.ast.ASTDmlUndeleteStatement;
import net.sourceforge.pmd.lang.apex.ast.ASTDmlUpdateStatement;
import net.sourceforge.pmd.lang.apex.ast.ASTDmlUpsertStatement;
import net.sourceforge.pmd.lang.apex.ast.ASTUserClass;
import net.sourceforge.pmd.lang.apex.ast.ASTUserInterface;
import net.sourceforge.pmd.lang.apex.rule.AbstractApexRule;
import net.sourceforge.pmd.lang.ast.AbstractNode;
import net.sourceforge.pmd.lang.ast.Node;

public class NoDmlOutsideOfUnitOfWorkRule extends AbstractApexRule {

    public NoDmlOutsideOfUnitOfWorkRule() {
        setProperty(CODECLIMATE_CATEGORIES, "Security");
        // Note: x10 as Apex has not automatic refactoring
        setProperty(CODECLIMATE_REMEDIATION_MULTIPLIER, 5);
        setProperty(CODECLIMATE_BLOCK_HIGHLIGHTING, false);
    }

    @Override
    public Object visit(ASTDmlDeleteStatement node, Object data) {
        if (!isUnitOfWorkClass(node)) {
            addViolation(data, node);
        }
        return data;
    }
    
    @Override
    public Object visit(ASTDmlInsertStatement node, Object data) {
    	if (!isUnitOfWorkClass(node)) {
            addViolation(data, node);
        }
        return data;
    }

    @Override
    public Object visit(ASTDmlMergeStatement node, Object data) {
    	if (!isUnitOfWorkClass(node)) {
            addViolation(data, node);
        }
        return data;
    }

    @Override
    public Object visit(ASTDmlUndeleteStatement node, Object data) {
    	if (!isUnitOfWorkClass(node)) {
            addViolation(data, node);
        }
        return data;
    }

    @Override
    public Object visit(ASTDmlUpdateStatement node, Object data) {
    	if (!isUnitOfWorkClass(node)) {
            addViolation(data, node);
        }
        return data;
    }

    @Override
    public Object visit(ASTDmlUpsertStatement node, Object data) {
    	if (!isUnitOfWorkClass(node)) {
            addViolation(data, node);
        }
        return data;
    }
    
    private Boolean isUnitOfWorkClass(AbstractNode node) {
        Node n = node.jjtGetParent();

        while (n != null) {
            if (n instanceof ASTUserClass || n instanceof ASTUserInterface) {
                if (n.getImage().contains("UnitOfWork")) {
                	return true;
                }
            }
            n = n.jjtGetParent();
        }

        return false;
    }
}
