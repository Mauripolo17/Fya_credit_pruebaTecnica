"use client"

import { useState } from "react"

export default function Sidebar() {
  const [activeItem, setActiveItem] = useState("solicitud")

  const menuItems = [
    {
      id: "solicitud",
      label: "Solicitud de Crédito",
      href: "/",
      icon: (
        <svg className="w-5 h-5" fill="none" stroke="currentColor" viewBox="0 0 24 24">
          <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M12 6v6m0 0v6m0-6h6m-6 0H6" />
        </svg>
      ),
    },
    {
      id: "ver-creditos",
      label: "Ver Créditos",
      href: "/creditos",
      icon: (
        <svg className="w-5 h-5" fill="none" stroke="currentColor" viewBox="0 0 24 24">
          <path
            strokeLinecap="round"
            strokeLinejoin="round"
            strokeWidth={2}
            d="M9 12h6m-6 4h6m2 5H7a2 2 0 01-2-2V5a2 2 0 012-2h5.586a1 1 0 01.707.293l5.414 5.414a1 1 0 01.293.707V19a2 2 0 01-2 2z"
          />
        </svg>
      ),
    },
  ]

  return (
    <div className="w-64 bg-white border-r border-gray-200 h-screen  left-0 top-0 z-10">
      <div className="p-6 border-b border-gray-200">
        <h2 className="text-xl font-bold text-gray-800">Sistema de Créditos</h2>
      </div>

      <nav className="mt-6">
        <ul className="space-y-2 px-4">
          {menuItems.map((item) => (
            <li key={item.id}>
              <span>
                {item.label}
              </span>
            </li>
          ))}
        </ul>
      </nav>
    </div>
  )
}
