package org.koreait.validators;

public interface RequiredValidator {//검증 요청시 문자열이 없거나 비어있는지 체크
    default void checkRequired(String str, RuntimeException e) {
        if (str == null || str.isBlank()) {
            throw e;
        }
    }
}