<script>
export default {
    name: 'FotoCard',
    data() {
        return {

        }
    },
    props: { foto: Object }
}
</script>

<template>
    <div class="card p-0 m-5" style="width: 20rem;">
        <img :src="foto.url" class="card-img-top" :alt="foto.name">
        <div class="card-body">
            <h3 class="card-title"> {{ foto.title }}</h3>
            <p class="card-text"> {{ foto.description }}</p>
            <p class="card-text"> <strong>Categorie: </strong> </p>
            <ul v-if="foto.categories.length > 0">
                <li v-for="category in foto.categories"> {{ category.name }} </li>
            </ul>
            <small v-else>Non ci sono categorie </small>
        </div>
    </div>
</template>

<style scoped></style>
