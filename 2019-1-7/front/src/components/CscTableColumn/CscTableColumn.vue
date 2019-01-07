<template>
</template>
<script>
  import ElementUI from 'element-ui'
  import { getPropByPath } from 'element-ui/src/utils/util';
  export default {
    name: 'CscTableColumn',

    extends: ElementUI.TableColumn,

    props: {
      enumType:String
    },

    created(){
      let _self = this;
      let renderCell = this.columnConfig.renderCell;
      this.columnConfig.renderCell = function(h, data) {
        if (_self.$scopedSlots.default) {
          renderCell = () => _self.$scopedSlots.default(data);
        }

        if (_self.enumType) {
          renderCell = function(h, { row, column }) {
            const property = column.property;
            const value = property && getPropByPath(row, property).v;
            if (column && column.formatter) {
              return column.formatter(row, column, value, _self.enumType);
            }
            return value;
          };
        }

        return renderCell(h, data);
      };

    }

  }
</script>