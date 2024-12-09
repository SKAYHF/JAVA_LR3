package tech.reliab.course.galushenkoLab.bank.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class EnhancedConsts {

    // Перечисление для хранения имен пользователей
    public enum PeopleNames {
        JOHN("John Doe", "Работает в IT"),
        JANE("Jane Smith", "Дизайнер"),
        DAVID("David Johnson", "Финансовый аналитик"),
        EMILY("Emily Davis", "Маркетолог"),
        MICHAEL("Michael Brown", "Инженер");

        private final String fullName;
        private final String description;

        PeopleNames(String fullName, String description) {
            this.fullName = fullName;
            this.description = description;
        }

        public String getFullName() {
            return fullName;
        }

        public String getDescription() {
            return description;
        }

        // Метод для получения случайного имени
        public static PeopleNames getRandomPerson() {
            Random random = new Random();
            PeopleNames[] people = PeopleNames.values();
            return people[random.nextInt(people.length)];
        }
    }

    // Перечисление для хранения названий компаний
    public enum CompanyNames {
        TECH_CORP("TechCorp", "Технологическая компания"),
        FINANCE_SOLUTIONS("FinanceSolutions", "Финансовые услуги"),
        ALPHA_BANK("AlphaBank", "Банк международного уровня"),
        BETA_ENTERPRISES("BetaEnterprises", "Консалтинговая компания"),
        OMEGA_SYSTEMS("OmegaSystems", "IT-интегратор");

        private final String companyName;
        private final String description;

        CompanyNames(String companyName, String description) {
            this.companyName = companyName;
            this.description = description;
        }

        public String getCompanyName() {
            return companyName;
        }

        public String getDescription() {
            return description;
        }

        // Метод для получения случайной компании
        public static CompanyNames getRandomCompany() {
            Random random = new Random();
            CompanyNames[] companies = CompanyNames.values();
            return companies[random.nextInt(companies.length)];
        }
    }

    // Дополнительные методы для работы с данными
    public static String getRandomPersonWithDescription() {
        PeopleNames person = PeopleNames.getRandomPerson();
        return person.getFullName() + " — " + person.getDescription();
    }

    public static String getRandomCompanyWithDescription() {
        CompanyNames company = CompanyNames.getRandomCompany();
        return company.getCompanyName() + " — " + company.getDescription();
    }
}
