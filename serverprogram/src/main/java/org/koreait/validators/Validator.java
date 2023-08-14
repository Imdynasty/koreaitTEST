package org.koreait.validators;

public interface Validator<T> {//어떠한 클래스도 검증받을수 있도록 제네릭형태
    void check(T t);
}
