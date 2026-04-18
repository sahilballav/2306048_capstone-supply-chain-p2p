import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

export default defineConfig({
  plugins: [react()],
  server: {
    proxy: {
      // ... inside server.proxy
'/api': {
  target: 'https://sahil-p2p-backend-mediating-panda-io.cfapps.ap21.hana.ondemand.com',
  changeOrigin: true,
  secure: false,
}
    }
  }
})