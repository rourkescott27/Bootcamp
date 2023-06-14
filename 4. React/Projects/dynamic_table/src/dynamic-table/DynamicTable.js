import { useEffect } from "react";
import TableData from "./TableData";

function DynamicTable() {
    // Get table column
    const column = Object.keys(TableData[0]);
    // Get table heading data
    const ThData = () => {
        return column.map((data) => {
            return <th key={data}>{data}</th>
        })
    }

    // Get table row data
    const tdData = () => {
        return TableData.map((data) => {
            return (
                <tr>
                    {
                        column.map((v) => {
                            return <td>{data[v]}</td>
                        })
                    }
                </tr>
            )
        })
    }

    return (
        <table className="table">
            <thead>
                <tr>{ThData()}</tr>
            </thead>
            <tbody>
                {tdData()}
            </tbody>
        </table>
    )
}

export default DynamicTable;