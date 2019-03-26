import enums from "@/utils/enums"

export  function getEnumObj(enumType){
  if(enums.hasOwnProperty(enumType)){
    return enums[enumType]
  }
}

export  function formatter(enumType,val){
  // console.log("begin to format...")
  if(enums.hasOwnProperty(enumType)){
    var obj = enums[enumType]
    if(obj.hasOwnProperty(val)){
      return obj[val]
    }else{
      return val
    }
  }else{
    return val
  }

}


