<script>
import axios from 'axios';
const base_url = "http://localhost:8080/api/foto"
import FotoCard from './components/FotoCard.vue';
export default {
  name: "AppAlbum",
  data() {
    return {
      foto: null,
      searchTerm: ""
    }
  },
  components: { FotoCard },
  methods: {
    fetchFoto() {
      axios.get(base_url).then(res => {
        this.foto = res.data;
      }).catch(e => {
        console.log(e);
      })
    },

    filterFoto(searchTitle) {
      axios.get(base_url + "/filter", { params: { title: searchTitle } }).then(res => {
        this.foto = res.data;
      }).catch(e => {
        console.log(e);
      })
    }
  },
  mounted() {
    this.fetchFoto()
  }
}
</script>

<template>
  <!-- HEADER -->
  <header class="container my-3">
    <nav class="navbar">
      <h1 class="text-danger">Album</h1>
      <a href="http://localhost:8080" class="btn btn-outline-success">Accedi</a>
    </nav>
  </header>

  <!-- MAIN -->
  <main class="container">
    <div class="row mb-5">
      <div class="col-4 ms-auto">
        <!-- SEARCH -->
        <div class="input-group">
          <input @keyup.enter="filterFoto(searchTerm)" type="text" class="form-control"
            placeholder="Filtra per titolo foto..." v-model="searchTerm">
          <button @click="filterFoto(searchTerm)" class="btn btn-outline-secondary" type="button">Filtra</button>
        </div>
      </div>
    </div>

    <div class="row">
      <FotoCard v-for="foto in foto" :foto="foto" :key="foto.id" />
    </div>


  </main>
</template>

<style scoped></style>
