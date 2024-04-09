package pro.sky.homework211.service;

import org.apache.commons.lang3.StringUtils;
import pro.sky.homework211.exception.EmployeeInputBadRequest;

public class EmployeeInput {

    public static String checkName(String n) {

        if (!StringUtils.isAlpha(n)) {
            throw new EmployeeInputBadRequest();
        } else {
            return StringUtils.capitalize(StringUtils.lowerCase(n));
        }

    }

}