<template>
  <v-textarea
    color="bluePi"
    :rows="rows"
    :label="label"
    :value="value"
    auto-grow
    @input="$emit('input', $event)"
  />
</template>

<script>
export default {
  name: 'TextArea',
  props: {
    label: {
      type: String,
      required: true
    },
    value: {
      type: String,
      required: true
    },
    rows: {
      type: String,
      default: '1'
    }
  }
}
</script>

<style>

</style>
