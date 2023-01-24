import FifthComponent from "./FifthComponent";
import FirstComponent from "./FirstComponent";
import FourthComponent from "./FourthComponent";
import LearningJavaScript from "./LearningJavaScript";
import { SixthComponent } from "./ThirdComponent";

export default function LearningComponent() {
  return (
    <div className="App">
      <FirstComponent />
      <FourthComponent />
      <FifthComponent />
      <SixthComponent />
      <LearningJavaScript />
    </div>
  );
}
