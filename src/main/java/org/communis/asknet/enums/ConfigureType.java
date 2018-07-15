package org.communis.asknet.enums;

public enum ConfigureType {
    DATA {
        @Override
        public String getFriendlyName() {
            return "Данные";
        }
    }, VALUE {
        @Override
        public String getFriendlyName() {
            return "Значение";
        }
    },VIEW {
        @Override
        public String getFriendlyName() {
            return "Предаставление";
        }
    }, VIEW_FRAGMENT {
        @Override
        public String getFriendlyName() {
            return "Предаставление (фрагмент)";
        }
    }, TRANSFORM {
        @Override
        public String getFriendlyName() {
            return "Преобразование";
        }
    }, LOGIC {
        @Override
        public String getFriendlyName() {
            return "Логика";
        }
    };

    public abstract String getFriendlyName();
}
