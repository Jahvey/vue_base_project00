export default  {
  isArray: function (o) {
    return Object.prototype.toString.call(o) == '[object Array]';
  },

  /*判断对象是否非空*/
  isEmpty: function (obj) {
    if (obj === undefined) {
      return true
    } else {
      if (typeof(obj) === "object") {
        for (var key in obj) {
          return false
        }
        return true
      } else {
        return true
      }
    }

  },

  dateformat: function () {
    Date.prototype.format = function (fmt) {
      var o = {
        "M+": this.getMonth() + 1, //月份
        "d+": this.getDate(), //日
        "h+": this.getHours(), //小时
        "m+": this.getMinutes(), //分
        "s+": this.getSeconds(), //秒
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度
        "S": this.getMilliseconds() //毫秒
      };
      if (/(y+)/.test(fmt)) {
        fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
      }
      for (var k in o) {
        if (new RegExp("(" + k + ")").test(fmt)) {
          fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        }
      }
      return fmt;
    };
  },

  timeStampToDateTime: function (timestamp) {
    var date = new Date(timestamp);
    return date.format('yyyy-MM-dd hh:mm:ss');
  },

  timeStampToDate: function (timestamp) {
    var date = new Date(timestamp);
    return date.format('yyyy-MM-dd');
  },

  formatDateString(val, format){
    if (typeof(val) == 'string' && val.length == 14) {
      var str = val.substr(0, 4) + "-" + val.substr(4, 2) + "-" + val.substr(6, 2) + " "
        + val.substr(8, 2) + ":" + val.substr(10, 2) + ":" + val.substr(12, 2);
      var date = new Date(str)
      return date.format(format)
    }
  },

  stringToDate(val){
    if (typeof(val) == 'string' && val.length == 14) {
      var str = val.substr(0, 4) + "-" + val.substr(4, 2) + "-" + val.substr(6, 2) + " "
        + val.substr(8, 2) + ":" + val.substr(10, 2) + ":" + val.substr(12, 2);
      var date = new Date(str)
      return date
    }
  },

  dateToShortString(date){
    return date.format('yyyyMMddhhmmss');
  },

  /**
   * 对象合并,覆盖已有属性
   * @param copyObj
   * @param fromObj
   */
  extend(copyObj, fromObj) {
    if (typeof(copyObj) === "object" && typeof(fromObj) === "object") {
      for (var p in fromObj) {
        if (fromObj.hasOwnProperty(p))
          copyObj[p] = fromObj[p];
      }
    }
  },

  /**
   * 格式化金额为千分位分隔符
   *    金额类两位小数 千分分隔符     #,##0.00
   *    利率类                        ###0.000000
   *    利率浮动幅度                  ###0.0000
   */
  numberToPercent(val, pattern){
    // console.log("numberToPercent:"+val);
    if(val){
      let re = /\d{1,3}(?=(\d{3})+$)/g;
      let n1 = val.toString().replace(/^(\d+)((\.\d+)?)$/, function (s, s1, s2) {
        return s1.replace(re, "$&,") + s2;
      });
      return n1;
    }else{
      val="437944.876544";
      let re = /\d{1,3}(?=(\d{3})+$)/g;
      let n1 = val.toString().replace(/^(\d+)((\.\d+)?)$/, function (s, s1, s2) {
        return s1.replace(re, "$&,") + s2;
      });
      return n1;
    }
  },
  /**
   * 测试匹配千分位分隔符的问题
   * @param val
   * @param pattern
   * @returns {*}
   */
  numberToPercent1(val,pattern){
    if(val){
      return val.replace(/(\d)(?=(\d{3})+$)/g,'$1,');
    }else{
      val="437944.929434";
      return val.replace(/(\d)(?=(\d{3})+$)/g,'$1,');
    }
  },
  /**
   * 该方法和numberToPercent1 大同小异
   * @param val
   * @param pattern
   * @returns {*}
   */
  numberToPercent2(val,pattern){
    if(val){
      return val.replace(/(?=(?!\b)(\d{3})+$)/g,',');
    }else{
      val="437944";
      return val.replace(/(?=(?!\b)(\d{3})+$)/g,',');
    }
  },

  delcommafy(num){//去除千分位中的‘，’
    num = num.toString();
    num = num.replace(/,/gi, '');
    return num;
  }

}
