// script.js
document.addEventListener("DOMContentLoaded", function() {
    var btn = document.getElementById("openModalBtn");
    var modalContainer = document.getElementById("modalContainer");

    btn.onclick = function() {
        fetch(`dor/detail.jsp`)// 发起一个 GET 请求，请求 'dor/detail.jsp' 文件
            .then(response => response.text())// 将响应数据解析为文本格式
            .then(data => {
                modalContainer.innerHTML = data;// 将解析后的 HTML 数据插入到页面中 id 为 'modalContainer' 的容器内
                var modal = document.getElementById("myModal");// 获取模态窗口的 DOM 元素
                var span = modal.getElementsByClassName("closeBtn")[0];// 获取模态窗口中的关闭按钮
                modal.style.display = "block"; // 将模态窗口显示出来
                // 为关闭按钮绑定点击事件，当点击时隐藏模态窗口
                span.onclick = function() {
                    modal.style.display = "none";
                }
                // 当点击模态窗口以外的区域时，隐藏模态窗口
                window.onclick = function(event) {
                    if (event.target == modal) {
                        modal.style.display = "none";
                    }
                }
            })// 捕获并处理请求过程中发生的任何错误
            .catch(error => console.log('Error:', error));
    }
});
