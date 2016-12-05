package ch.gmtech.learning.refactoring.introduceassertion;

public class Employee {

	private static final double NULL_EXPENSE = -1.0;
	private double _expenseLimit = NULL_EXPENSE;
	private Project _primaryProject;
	
	public Employee(Project project) {
		_primaryProject = project;
	}

	public Employee(double expenseLimit) {
		_expenseLimit = expenseLimit;
	}

	private double getExpenseLimit() {
//		Assert.assertTrue(_expenseLimit != NULL_EXPENSE || _primaryProject != null);
		return (_expenseLimit != NULL_EXPENSE) ? _expenseLimit : _primaryProject.getMemberExpenseLimit();
	}

	public boolean withinLimit(double expenseAmount) {
		return (expenseAmount <= getExpenseLimit());
	}

}
