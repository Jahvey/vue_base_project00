export function isvalidUsername(str) {
  // const valid_map = ['admin', 'editor']
  // return valid_map.indexOf(str.trim()) >= 0
  return true;
}

/* 合法uri*/
export function validateURL(textval) {
  const urlregex = /^(https?|ftp):\/\/([a-zA-Z0-9.-]+(:[a-zA-Z0-9.&%$-]+)*@)*((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9][0-9]?)(\.(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])){3}|([a-zA-Z0-9-]+\.)*[a-zA-Z0-9-]+\.(com|edu|gov|int|mil|net|org|biz|arpa|info|name|pro|aero|coop|museum|[a-zA-Z]{2}))(:[0-9]+)*(\/($|[a-zA-Z0-9.,?'\\+&%$#=~_-]+))*$/
  return urlregex.test(textval)
}

/* 小写字母*/
export function validateLowerCase(str) {
  const reg = /^[a-z]+$/
  return reg.test(str)
}

/* 大写字母*/
export function validateUpperCase(str) {
  const reg = /^[A-Z]+$/
  return reg.test(str)
}

/* 大小写字母*/
export function validatAlphabets(str) {
  const reg = /^[A-Za-z]+$/
  return reg.test(str)
}

/*判断对象是否非空*/
export function isEmpty(obj) {
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
}

/**
 * 对象合并,覆盖已有属性
 * @param copyObj
 * @param fromObj
 */
export function extend(copyObj, fromObj) {
  if (typeof(copyObj) === "object" && typeof(fromObj) === "object") {
    for (var p in fromObj) {
      if (fromObj.hasOwnProperty(p))
        copyObj[p] = fromObj[p];
    }
  }

}

export function compareDate(d1,d2){
  if(d1 != null && d1 != undefined && d2 != null && d2 != undefined
  && d1 instanceof Date && d2 instanceof Date){
    if(d1 > d2){
      return true;
    }else{
      return false;
    }
  }
}


