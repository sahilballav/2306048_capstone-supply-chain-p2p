import { useState, useEffect } from 'react'
import axios from 'axios'
import './App.css'

function App() {
  const [materials, setMaterials] = useState([])
  const [loading, setLoading] = useState(true)

  useEffect(() => {
    fetchInventory()
  }, [])

  const fetchInventory = async () => {
    try {
      const response = await axios.get('/api/inventory/materials')
      setMaterials(response.data)
      setLoading(false)
    } catch (error) {
      console.error(error)
      setLoading(false)
    }
  }

  const handleReorder = async (materialId) => {
    try {
      await axios.post('/api/inventory/requisition', {
        materialId: materialId,
        requestedQuantity: 50,
        status: "PENDING_APPROVAL"
      })
      alert("Purchase Requisition Generated Successfully!")
    } catch (error) {
      console.error(error)
    }
  }

  if (loading) return <div className="loading">Loading...</div>

  return (
    <div className="dashboard-container">
      <header className="dashboard-header">
        <h1>Smart Inventory & P2P Dashboard</h1>
        <p>Real-time SAP Material Management Extension</p>
      </header>
      <div className="inventory-grid">
        {materials.map((item) => {
          const isLowStock = item.currentStock <= item.minimumThreshold
          return (
            <div key={item.id} className={`inventory-card ${isLowStock ? 'critical-stock' : 'healthy-stock'}`}>
              <h3>{item.name}</h3>
              <div className="stock-details">
                <p>Current Stock: <strong>{item.currentStock}</strong></p>
                <p>Threshold: {item.minimumThreshold}</p>
              </div>
              {isLowStock && (
                <div className="action-area">
                  <span className="warning-badge">Stock Critical</span>
                  <button onClick={() => handleReorder(item.id)} className="reorder-btn">
                    Automate P2P Reorder
                  </button>
                </div>
              )}
            </div>
          )
        })}
      </div>
    </div>
  )
}

export default App