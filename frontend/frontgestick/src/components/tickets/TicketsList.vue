<template>
  <div>
    <table>
      <tr v-for="ticket in tickets" :key="ticket.id">
        <td>{{ ticket.title }}</td>
        <td>{{ ticket.status }}</td>
      </tr>
    </table>
    <button @click="$emit('refresh')">Refrescar</button>
  </div>
</template>

<script>
export default {
  name: "TicketsList",
  props: {
    tickets: Array,
  },
  emits: ["refresh"],
};
</script>
