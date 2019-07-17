
const blankValidator = value => {
    if(value != null && value.length){
        return null;
    }
    return "can't be blank";
};

const lengthValidator = (value, length) =>{
    if(value.length >= length){
        return null;
    }
    return `is too short (minimum is ${length} characters)`;
};

const emailValidator = email => {
    const re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(email).toLowerCase()) ? null : "is invalid";
};

const passwordConfirmationValidator = (password, confirmPassword) => {
    return password === confirmPassword ? null : "doesn't match Password";
};

export const validateEmail = value => {
    const blanckError = blankValidator(value);
    const emailError = emailValidator(value);
    if(blanckError){
        return blanckError;
    }

    if(emailError){
        return emailError;
    }

    return null;
};

export const validateNickname = value => {
    return blankValidator(value) ? blankValidator(value) : null;
};

export const passwordValidator = value => {
  return lengthValidator(value, 8) ? lengthValidator(value,8) : null;
};

export const confirmPasswordValidator = (password, confirmPassword) => {
  return password === confirmPassword ? null : "doesn't match Password";
};
