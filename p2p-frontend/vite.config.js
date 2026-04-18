import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

export default defineConfig({
  plugins: [react()],
  server: {
    proxy: {
      '/api': {
        target: 'https://port8080-workspaces-ws-270u1.ap21.trial.applicationstudio.cloud.sap',
        changeOrigin: true,
        secure: false,
      }
    }
  }
})