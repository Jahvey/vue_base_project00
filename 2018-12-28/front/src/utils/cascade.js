import govAreaCd from "@/utils/gov_province_city_area_id"

export default function(colName){
  switch(colName)
  {
    case 'govAreaCd':
      return govAreaCd
    default:
      return undefined
  }
}
