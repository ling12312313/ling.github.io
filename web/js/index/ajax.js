document.addEventListener("DOMContentLoaded", function() {
    console.log("DOM fully loaded and parsed");

    function loadContent(url) {
        var xhr = new XMLHttpRequest(); // 创建一个新的XMLHttpRequest对象
        xhr.open('GET', url, true); // 初始化请求
        xhr.onreadystatechange = function() {
            if (xhr.readyState === 4) { // 请求完成
                if (xhr.status === 200) { // 请求成功
                    document.querySelector('.main-content').innerHTML = xhr.responseText; // 插入返回的数据
                    initializeEvents(); // 初始化事件
                } else {
                    alert('无法加载内容'); // 请求失败
                }
            }
        };
        xhr.send(); // 发送请求
    }

    function initializeEvents() {
        // 为动态加载的内容重新绑定事件
        var button1 = document.getElementById("button1");
        if (button1) {
            button1.addEventListener("click", function() {
                alert("Button 1 clicked!");
            });
        }
    }

    // 尝试获取每个标签元素并绑定点击事件处理程序
    var tab1 = document.getElementById('tab1');
    var tab2 = document.getElementById('tab2');
    var tab3 = document.getElementById('tab3');
    var tab4 = document.getElementById('tab4');

    if (tab1) {
        tab1.addEventListener('click', function() {
            loadContent('/jsp/index/source1.jsp');
        });
    } else {
        console.error("Element with ID 'tab1' not found");
    }

    if (tab2) {
        tab2.addEventListener('click', function() {
            loadContent('web/jsp/index/class_inf.jsp');
        });
    } else {
        console.error("Element with ID 'tab2' not found");
    }

    if (tab3) {
        tab3.addEventListener('click', function() {
            loadContent('/jsp/index/source3.jsp');
        });
    } else {
        console.error("Element with ID 'tab3' not found");
    }

    if (tab4) {
        tab4.addEventListener('click', function() {
            loadContent('/jsp/index/source4.jsp');
        });
    } else {
        console.error("Element with ID 'tab4' not found");
    }
});
