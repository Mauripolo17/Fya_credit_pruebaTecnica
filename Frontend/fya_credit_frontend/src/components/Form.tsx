import type React from "react"
import { useState } from "react"
import { creditService } from "../services/CreditService"


export default function CreditForm() {
  const [formData, setFormData] = useState({
    nombreCliente: "",
    email: "",
    tipoDocumento: "Cedula de ciudadania",
    numeroDocumento: 0,
    valorCredito: 0,
    tasaInteres: 0,
    plazoMeses: 0,
    comercial: "",
    proposito: "",
  })

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault()
    console.log("Solicitud enviada:", formData)
    try{
        creditService.createCredit(formData)
    }catch (error) {
        console.error("Error al enviar la solicitud:", error)
        alert("Ocurrió un error al enviar la solicitud. Por favor, inténtalo de nuevo más tarde.")
    }
  }

  const handleInputChange = (field: string, value: string) => {
    setFormData((prev) => ({ ...prev, [field]: value }))
  }

  return (
    <div className="bg-white rounded-lg shadow-xl w-2xl mx-auto ">
      <div className="px-6 py-4 border-b border-gray-200">
        <h3 className="text-2xl font-semibold text-center text-gray-900">Solicitud de crédito</h3>
      </div>
      <div className="p-6">
        <form onSubmit={handleSubmit} className="space-y-6">
          <div className="grid sm:grid-cols-2 gap-4">
            <div className="space-y-2">
              <label htmlFor="nombreCliente" className="block text-sm font-medium text-gray-700">
                Nombre completo
              </label>
              <input
                id="nombreCliente"
                type="text"
                placeholder="Juan Pérez"
                value={formData.nombreCliente}
                onChange={(e) => handleInputChange("nombreCliente", e.target.value)}
                required
                className="w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-2 focus:ring-blue-500 focus:border-blue-500"
              />
            </div>
            <div className="space-y-2">
              <label htmlFor="email" className="block text-sm font-medium text-gray-700">
                Correo electrónico
              </label>
              <input
                id="email"
                type="email"
                placeholder="juan@ejemplo.com"
                value={formData.email}
                onChange={(e) => handleInputChange("email", e.target.value)}
                required
                className="w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-2 focus:ring-blue-500 focus:border-blue-500"
              />
            </div>
          </div>
          <div className="grid sm:grid-cols-2 gap-4">
            <div className="space-y-2">
            <label htmlFor="tipoDocumento" className="block text-sm font-medium text-gray-700">
                Tipo de documento
              </label>
              <select
                id="tipoDocumento"
                value={formData.tipoDocumento}
                onChange={(e) => handleInputChange("tipoDocumento", e.target.value)}
                required
                className="w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-2 focus:ring-blue-500 focus:border-blue-500"
              >
                <option value="Cedula de ciudadania">Cedula de ciudadania</option>
                <option value="Pasaporte">Pasaporte</option>
                <option value="Cedula extranjera">Cedula extranjera</option>
              </select>
            </div>
            <div className="space-y-2">
              <label htmlFor="numeroDocumento" className="block text-sm font-medium text-gray-700">
                Numero de documento
              </label>
              <input
                id="numeroDocumento"
                type="number"
                placeholder="12345679"
                value={formData.numeroDocumento}
                onChange={(e) => handleInputChange("numeroDocumento", e.target.value)}
                required
                className="w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-2 focus:ring-blue-500 focus:border-blue-500"
              />
            </div>
          </div>

          <div className="grid sm:grid-cols-2 gap-4">
            <div className="space-y-2">
              <label htmlFor="valorCredito" className="block text-sm font-medium text-gray-700">
                Valor del credito
              </label>
              <input
                id="valorCredito"
                type="number"
                min={100000}
                max={10000000}
                placeholder="250000"
                value={formData.valorCredito}
                onChange={(e) => handleInputChange("valorCredito", e.target.value)}
                required
                className="w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-2 focus:ring-blue-500 focus:border-blue-500"
              />
            </div>
            <div className="space-y-2">
              <label htmlFor="tasaInteres" className="block text-sm font-medium text-gray-700">
                Tasa de interés (%)
              </label>
              <input
                id="tasaInteres"
                type="number"
                placeholder="15.5"
                value={formData.tasaInteres}
                onChange={(e) => handleInputChange("tasaInteres", e.target.value)}
                required
                min="0"
                step="0.1"
                className="w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-2 focus:ring-blue-500 focus:border-blue-500"
              />
            </div>
          </div>

          <div className="grid sm:grid-cols-2 gap-4">
            <div className="space-y-2">
              <label htmlFor="plazoMeses" className="block text-sm font-medium text-gray-700">
                Plazo en meses
              </label>
              <select
                id="plazoMeses"
                value={formData.plazoMeses}
                onChange={(e) => handleInputChange("plazoMeses", e.target.value)}
                required
                className="w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-2 focus:ring-blue-500 focus:border-blue-500"
              >
                <option value="">Selecciona el plazo</option>
                <option value="6">6 meses</option>
                <option value="12">12 meses</option>
                <option value="18">18 meses</option>
                <option value="24">24 meses</option>
                <option value="36">36 meses</option>
                <option value="48">48 meses</option>
                <option value="60">60 meses</option>
              </select>
            </div>
            <div className="space-y-2">
              <label htmlFor="comercial" className="block text-sm font-medium text-gray-700">
                Comercial que registra
              </label>
              <input
                id="comercial"
                type="text"
                placeholder="María González"
                value={formData.comercial}
                onChange={(e) => handleInputChange("comercial", e.target.value)}
                required
                className="w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-2 focus:ring-blue-500 focus:border-blue-500"
              />
            </div>
          </div>

          <div className="space-y-2">
            <label htmlFor="proposito" className="block text-sm font-medium text-gray-700">
              Propósito del crédito
            </label>
            <textarea
              id="proposito"
              placeholder="Describe brevemente para qué necesitas el crédito..."
              value={formData.proposito}
              onChange={(e) => handleInputChange("proposito", e.target.value)}
              rows={3}
              className="w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-2 focus:ring-blue-500 focus:border-blue-500 resize-none"
            />
          </div>

          <button
            type="submit"
            className="w-full bg-blue-600 hover:bg-blue-700 text-white font-semibold text-lg py-3 px-4 rounded-md transition-colors duration-200 flex items-center justify-center space-x-2"
          >
            <span>Solicitar crédito</span>
          </button>
        </form>
      </div>
    </div>
  )
}
