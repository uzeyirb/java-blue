import Vue from 'vue'
import VueRouter from 'vue-router'
import Products from '@/views/Products'
import ProductDetail from '@/views/ProductDetail'
import AddReview from '@/views/AddReview'
import NotFound from '@/views/NotFound.vue'
import Store from '@/store/index'
import Watcher from '@/views/Watcher'
Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'products',
    component: Products
  },
  {
    path: '/products/:id',
    name: 'product-detail',
    component: ProductDetail
  },
  {
    path: '/products/:id/add-review',
    name: 'add-review',
    component: AddReview
  },
  {
    path: '/products',
    redirect: { name: 'products' }
  },
  {
    path: '/watcher',
    name: 'watcher',
    component: Watcher
  },
  {
    path: '*',
    name: 'not-found',
    component: NotFound
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

/*
  to - where the user is going
  from - where the user came from
  next - a function that will send them to their next location
*/
router.beforeEach( (to, from, next) => {
  // Check if going to ProductDetail or AddReview
  if (to.name == 'product-detail' || to.name == 'add-review') {
    // If so, get the Id from the parameters in the url
    const id = to.params.id;
    // Check if the id exists in the VueX Store
    const product = Store.state.products.find( p => { return p.id == id});
    // If it does, continue as normal
    // If it does not, redirect to the 404 Not Found page
    if (!product) {
      next( { name: 'not-found'} );
    }
  }
  // continue as normal
  next();
})

export default router
