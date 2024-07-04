function includeB(action) {
    // 创建一个新的iframe元素
    var iframe = document.createElement('iframe');
    iframe.src = 'web/jsp/index/' + action; // 设置iframe的src，注意路径和参数的拼接方式
    iframe.style.width = '100%'; // 设置iframe宽度
    iframe.style.height = '100%'; // 设置iframe高度，确保填满main-content区域
    iframe.style.border = 'none'; // 去掉iframe边框

    // 获取main-content的元素，将iframe添加进去
    var mainContent = document.getElementById('main-content');
    mainContent.innerHTML = ''; // 清空main-content内容
    mainContent.appendChild(iframe); // 将iframe添加到main-content中
}
