cb.widgets.register('MemberNav', function(widgetType) {
	var widget = function(id, options) {
		cb.widgets.BaseWidget.call(this, id, options);
	};
	widget.prototype = new cb.widgets.BaseWidget();
	widget.prototype.widgetType = widgetType;
	widget.prototype.runTemplate = function() {
		$('i.icon').on('click', function() {
			$(this).toggleClass('icon');
			$(this).toggleClass('icon1');
			//$(this).nextAll('ul').toggle();
		});
		var img = new Image();
		img.src = "http://photo123456apple.oss-cn-beijing.aliyuncs.com/photo/products/21/20150918/lm_dbaf8920-5f39-4a2a-8c31-2d3585a0aba4.jpg";
		img.onerror = function() {
			alert(name + " 图片加载失败，请检查url是否正确");
			return false;
		};
		if (img.complete) {
			console.log(img.width + " " + img.height);
		} else {
			img.onload = function() {
				console.log(img.width + " " + img.height);
				img.onload = null; //避免重复加载
			}
		}
		var url = cb.rest._getUrl(window.location.href);
		if (url.substr(url.length - 1, 1) === '/') {
			url = url.substr(0, url.length - 1);
		}
		var realUrl = url.split('http://' + window.location.host);
		var realurl = realUrl[1].split('?')[0];
		if (realurl === '/member') return;
		for (var i = 0; i < $('ul.nav_list li a').length; i++) {
			if ($('ul.nav_list li a:eq(' + i + ")").attr('href') === realurl) {
				$('ul.nav_list li a:eq(' + i + ")").closest('li').addClass('active');
				return;
			}
		}
	}
	return widget;
});