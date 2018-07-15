package org.communis.asknet.enums;

public enum DataFieldType {
    String {
        @Override
        public String getFriendlyName() {
            return "Строка";
        }
    }, Num {
        @Override
        public String getFriendlyName() {
            return "Число";
        }
    }, List {
        @Override
        public String getFriendlyName() {
            return "Список";
        }
    }, File {
        @Override
        public String getFriendlyName() {
            return "Файд";
        }
    }, Object {
        @Override
        public String getFriendlyName() {
            return "Объект";
        }
    };

    public abstract String getFriendlyName();
}
