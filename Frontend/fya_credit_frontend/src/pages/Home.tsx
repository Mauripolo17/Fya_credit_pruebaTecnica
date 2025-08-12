import { useState } from "react";
import CreditosPage from "../components/CreditosPage";
import CreditForm from "../components/Form";
import Sidebar from "../components/Sidebar";

export default function Home() {

    const [activeItem, setActiveItem] = useState("solicitud")

    const menuItems = [
        {
            id: "solicitud",
            label: "Solicitud de Crédito",
            href: "/"
        },
        {
            id: "ver-creditos",
            label: "Ver Créditos",
            href: "/creditos"
        },
    ]
    return (
        <div className="flex">
            <div className="w-64 bg-white border-r border-gray-200 h-screen  left-0 top-0 z-10">
                <div className="p-6 border-b border-gray-200">
                    <h2 className="text-xl font-bold text-gray-800">Sistema de Créditos</h2>
                </div>
                <nav className="mt-6">
                    <ul className="space-y-2 px-4">
                        {menuItems.map((item) => (
                            <li key={item.id}>
                                <button onClick={() => { setActiveItem(item.id) }} className="color-gray-700 hover:bg-gray-100 flex items-center space-x-2 p-2 rounded-md w-full text-left">
                                    <span>
                                        {item.label}
                                    </span>
                                </button>
                            </li>
                        ))}
                    </ul>
                </nav>
            </div>
            {activeItem == "solicitud" ? <CreditForm /> :
                <CreditosPage />}
        </div>
    )
} 