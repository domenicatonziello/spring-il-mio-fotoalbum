<script>
import axios from 'axios';
const base_url = "http://localhost:8080/api/foto"
import FotoCard from './components/FotoCard.vue';
export default {
  name: "AppAlbum",
  data() {
    return {
      foto: null,
      searchTerm: "",
      contatto: { email: "", message: "" },
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
    },
    sendMessage(emailForm, messageForm) {
      axios.post("http://localhost:8080/api/contact/store", this.contatto)
        .then(res => {
          console.log(res.data);
        }).catch(e => { console.log(e); })
      this.contatto.email = "";
      this.contatto.message = "";
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
      <a href="http://localhost:8080" class="btn btn-outline-success">Accedi all'area riservata</a>
    </nav>
  </header>

  <!-- MAIN -->
  <main class="container">
    <!-- FILTRO -->
    <div class="row mb-5">
      <div class="col-4 mx-auto">
        <div class="input-group">
          <input @keyup.enter="filterFoto(searchTerm)" type="text" class="form-control"
            placeholder="Filtra per titolo foto..." v-model="searchTerm">
          <button @click="filterFoto(searchTerm)" class="btn btn-outline-secondary" type="button">Filtra</button>
        </div>
      </div>
    </div>
    <!-- ELENCO FOTO -->
    <section class="my-5">
      <div class="row">
        <FotoCard v-for="foto in foto" :foto="foto" :key="foto.id" />
      </div>
    </section>

    <!-- FORM DI CONTATTO -->
    <section class="my-5">
      <h2>Contattaci</h2>
      <form>
        <div class="row">
          <div class="col-7 mb-3">
            <label for="email" class="form-label">Indirizzo email</label>
            <input type="email" class="form-control" id="email" name="email" v-model="contatto.email">
            <div class="form-text">Inserisci il tuo indirizzo email</div>
          </div>
          <div class="col-7 mb-3">
            <label for="massage" class="form-label">Messaggio</label>
            <textarea class="form-control" id="message" name="message" rows="1" v-model="contatto.message"></textarea>
          </div>
        </div>
        <button type="button" class="btn btn-primary"
          @click="sendMessage(contatto.email, contatto.message)">Invia</button>
      </form>
    </section>


  </main>
</template>

<style scoped></style>
