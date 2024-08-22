import { Carousel } from "./components/Carousel";
import { ExploreTopBooks } from "./components/ExploreTopBooks";
import { Heros } from "./components/Heros"; 
import { LibraryServices } from "./components/LibraryServices";
// import Signup from "./components/Signup";
export const HomePage = () => {
     return(
        <>            
         <ExploreTopBooks/>
             {/* <Carousel/> */}
             <Heros/>
             <LibraryServices/>
             {/* <Signup/> */}
             </>

     );
}