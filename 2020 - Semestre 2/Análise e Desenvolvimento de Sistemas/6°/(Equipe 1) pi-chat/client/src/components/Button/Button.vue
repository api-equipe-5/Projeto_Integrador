<template>
    <v-btn
      dark
      color="bluePi"
      :icon="icon"
      :fab="fab"
      :right="right"
      :bottom="bottom"
      :fixed="fixed"
      @click="$emit('click')"
    >
      <slot></slot>
    </v-btn>
</template>

<script>
export default {
  name: 'Button',
  props: {
    icon: {
      type: Boolean,
      default: false
    },
    fab: {
      type: Boolean,
      default: false
    },
    right: {
      type: Boolean,
      default: false
    },
    bottom: {
      type: Boolean,
      default: false
    },
    fixed: {
      type: Boolean,
      default: false
    }
  }
}
</script>
<style scoped>
</style>
