package com.bergaz.fundamentals.collections_2020_version;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MutableHashMapKeys {
    public static void main(String[] args) {
        Map<MutableString, String> brokenMap = new HashMap<>();

        final String value = "abc";

        final MutableString key = new MutableString(value);
        brokenMap.put(key, value);

        System.out.println(brokenMap.get(key));
        System.out.println(brokenMap);

        /**
         * By mutating that value we break the calculated hash value
         */
        key.set("def");

        System.out.println(brokenMap.get(key));
        System.out.println(brokenMap);

    }

    private static class MutableString {
        private String value;

        public MutableString(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void set(String def) {
            Objects.requireNonNull(def);
            this.value = def;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            MutableString that = (MutableString) obj;
            return value.equals(that.getValue());
        }

        @Override
        public int hashCode() {
            return value.hashCode();
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }
}
