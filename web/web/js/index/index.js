// script.js
function loadImage() {
    // 获取 <main> 元素
    var main = document.querySelector('main');

    // 创建新的 <img> 元素
    var img = document.createElement('img');
    img.src = 'web/image/img.png'; // 设置图片路径
    img.alt = '描述图片的替代文本'; // 设置替代文本
    img.width = 1350; // 设置图片宽度
    img.height = 600; // 设置图片高度

    // 清空 <main> 的内容
    main.innerHTML = '';

    // 将图片添加到 <main> 中
    main.appendChild(img);
}
