package tech.reliab.course.galushenkoLab.bank.exceptions;

public class CreditExceptions {

    // Базовое исключение для всех кредитных ошибок
    public static class CreditException extends Exception {
        public CreditException(String message) {
            super(message);
        }
    }

    // Исключение: Низкий кредитный рейтинг
    public static class LowCreditRatingException extends CreditException {
        public LowCreditRatingException(int rating, int requiredRating) {
            super("User's credit rating " + rating + " is below required " + requiredRating + ".");
        }
    }

    // Исключение: Недостаточно средств в банкомате
    public static class InsufficientFundsAtmException extends CreditException {
        public InsufficientFundsAtmException(double requested, double available) {
            super("ATM has insufficient funds. Requested: " + requested + ", Available: " + available + ".");
        }
    }

    // Исключение: Офис не поддерживает выдачу кредитов
    public static class OfficeDoesNotSupportLoansException extends CreditException {
        public OfficeDoesNotSupportLoansException(String officeName) {
            super("Office '" + officeName + "' does not support loan issuance.");
        }
    }

    // Исключение: Нет сотрудника, способного выдать кредит
    public static class NoQualifiedEmployeeException extends CreditException {
        public NoQualifiedEmployeeException(String officeName) {
            super("No qualified employee found in office '" + officeName + "' to issue loans.");
        }
    }

    // Исключение: Не удалось создать счет в банке
    public static class BankAccountCreationFailedException extends CreditException {
        public BankAccountCreationFailedException(String userName, String bankName) {
            super("Failed to create a payment account for user '" + userName + "' in bank '" + bankName + "'.");
        }
    }
}
