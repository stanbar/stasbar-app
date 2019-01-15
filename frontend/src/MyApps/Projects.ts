/*
 * Copyright 2019 Stanislaw Baranski @stasbar
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 *          __             __
 *    _____/ /_____ ______/ /_  ____ ______
 *   / ___/ __/ __ `/ ___/ __ \/ __ `/ ___/
 *  (__  ) /_/ /_/ (__  ) /_/ / /_/ / /
 * /____/\__/\__,_/____/_.___/\__,_/_/
 *            stasbar@stasbar.com
 */
import RaspberryWalletFramedPng from "../assets/png/RaspberryWallet/RaspberryWalletFramed.png"
import RaspberryWalletFramedWebp from "../assets/webp/RaspberryWallet/RaspberryWalletFramed.webp"
import MyWebsiteRecurrenceFramedPng from "../assets/png/MyWebsite/MyWebsiteRecurrenceFramed.png"
import MyWebsiteRecurrenceFramedWebp from "../assets/webp/MyWebsite/MyWebsiteRecurrenceFramed.webp"
import IApp from "./IApp";


const Projects: IApp[] = [
  {
    name: "Raspberry Wallet",
    imgSrc: RaspberryWalletFramedPng,
    imgWebp: RaspberryWalletFramedWebp,
    description: "Bitcoin hardware wallet on Raspberry Pi Zero",
    platform: "desktop",
    links: {
      website: "https://raspberrywallet.github.io/readme.html",
      github: "https://github.com/RaspberryWallet",
      googlePlay: null,
      appStore: null,
    }
  },
  {
    name: "website",
    imgSrc: MyWebsiteRecurrenceFramedPng,
    imgWebp: MyWebsiteRecurrenceFramedWebp,
    description: "This website & android app itself are good pieces of software, so I think it's worth mention here",
    platform: "desktop",
    links: {
      website: null,
      github: "https://github.com/stasbar/stasbar-app",
      googlePlay: null,
      appStore: null,
    }
  }
];

export default Projects
