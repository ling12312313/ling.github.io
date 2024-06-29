function handleResponse(isSuccess) {
    if (isSuccess === 'true') {
        alert('修改成功!');
    } else {
        alert('修改失败!');
    }
}
function validateForm() {
    var password = document.getElementById("new_password").value;
    var confirmPassword = document.getElementById("confirm_password").value;

    if (password !== confirmPassword) {
        alert("两次输入的密码不相同，请重新输入。");
        return false; // 阻止表单提交
    }
    return true; // 允许表单提交
}