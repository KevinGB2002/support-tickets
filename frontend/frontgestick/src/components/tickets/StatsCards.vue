<template>
  <div class="grid grid-cols-1 sm:grid-cols-3 gap-6">
    <div class="bg-blue-500 text-white p-6 rounded-lg shadow">
      <h3 class="text-lg font-semibold">Total</h3>
      <p class="text-2xl font-bold">{{ total }}</p>
    </div>
    <div class="bg-green-500 text-white p-6 rounded-lg shadow">
      <h3 class="text-lg font-semibold">Abiertos</h3>
      <p class="text-2xl font-bold">{{ open }}</p>
    </div>
    <div class="bg-gray-700 text-white p-6 rounded-lg shadow">
      <h3 class="text-lg font-semibold">Cerrados</h3>
      <p class="text-2xl font-bold">{{ closed }}</p>
    </div>
  </div>
</template>

<script setup>
import { computed } from "vue";

const props = defineProps({
  tickets: {
    type: Array,
    required: true,
  },
});

const total = computed(() => props.tickets.length);
const open = computed(() =>
  props.tickets.filter((t) => t.status === "OPEN").length
);
const closed = computed(() =>
  props.tickets.filter((t) => t.status === "CLOSED").length
);
</script>
