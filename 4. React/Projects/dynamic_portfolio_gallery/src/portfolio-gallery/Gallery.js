import { useState } from 'react';
import Tabs from './Tabs';
import Items from './Items';
import Data from './Data';


function Gallery() {

    const [data, setData] = useState(Data);
    const categoryData = Data.map((value) => {
        return value.category
    });

    const tabsData = ["all", ...new Set(categoryData)];

    const filterCategory = (category) => {
        if (category === "all") {
            setData(Data);
            return;
        }
        const filteredData = Data.filter((value) => {
            return value.category === category;
        })
        setData(filteredData)
    }

    return (
        <div className='container'>
            <div className='row'>
                <div className='col-sm-1'>

                </div>
                <div className='col-sm-10'>
                    <Tabs tabsData={tabsData} filterCategory={filterCategory} />
                    <Items data={data} />
                </div>
                <div className='col-sm-1'>

                </div>

            </div>

        </div>
    )
}

export default Gallery;