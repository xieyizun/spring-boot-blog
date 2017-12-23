package cn.com.xyz.blog.validator;

import cn.com.xyz.blog.entity.User;
import cn.com.xyz.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @projectName: SpringBootBlog
 * @packageName: cn.com.xyz.blog.validator
 * @author: gzxieyizun
 * @date: 2017/12/23
 * @description:
 */
@Component
public class UserValidator implements Validator {
    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(@Nullable Object o, Errors errors) {
        User user = (User)o;
        ValidationUtils.rejectIfEmpty(errors, "name", "NotEmpty");
        ValidationUtils.rejectIfEmpty(errors, "email", "NotEmpty");
        ValidationUtils.rejectIfEmpty(errors, "password", "NotEmpty");

        if (user.getName().length() < 3 || user.getName().length() > 32) {
            errors.rejectValue("name", "NameLength");
        }
        if (userService.findByUserEmail(user.getEmail()) != null) {
            errors.rejectValue("email", "EmailDuplication");
        }
    }
}
