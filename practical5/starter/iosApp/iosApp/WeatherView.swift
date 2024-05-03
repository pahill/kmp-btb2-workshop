import SwiftUI
import Shared
import Kingfisher

struct WeatherView: View {

    let capitalName: String

    let details: Weather

    let action: () -> ()

    init(capitalName: String, details: Weather, action: @escaping () -> ()) {
        self.capitalName = capitalName
        self.details = details
        self.action = action
    }

    var body: some View {
        ZStack {
            RoundedRectangle(cornerRadius: 25, style: .continuous)
                .fill(.white)
                .shadow(radius: 10)
            VStack {
                Button("Back") {
                    action()
                }.frame(width: 300, alignment: .leading).padding(20)
                Text(capitalName).font(.title)
                KFImage(URL(string: "https://openweathermap.org/img/wn/\(details.weather[0].icon)@2x.png")!)
                let feelsLikeFahrenheit = // TODO: Call top-level celsiusToFahrenheit function in shared code to convert temperature (details.main.feels_like)
                Text("Feels like: \(details.main.feels_like)'C / \(feelsLikeFahrenheit)'F" ).frame(width: 300, alignment: .leading).padding(5)
                let tempFahrenheit = // TODO: Call top-level celsiusToFahrenheit function in shared code to convert temperature (details.main.temp)
                Text("Temp: \(details.main.temp)'C / \(tempFahrenheit)'F").frame(width: 300, alignment: .leading).padding(EdgeInsets(top: 5, leading: 5, bottom: 15, trailing: 5))
            }
        }.frame(width: 300, height: 300)
    }
}
