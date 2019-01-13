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


import IApp from "./App";
import VapeToolLongFramedPng from "../assets/png/VapeTool/VapeToolLongFramed.png"
import GoLureLongFramedPng from "../assets/png/GoLure/GoLureLongFramed.png"
import Wallpapers4KLongFramedPng from "../assets/png/Wallpapers4K/Wallpapers4KLongFramed.png"
import WallpapersOneClickLongFramedPng from "../assets/png/WallpapersOneClick/WallpapersOneClickLongFramed.png"
import WishesLongFramedPng from "../assets/png/Wishes/WishesLongFramed.png"
import TaxLedgerFramedPng from "../assets/png/TaxLedger/TaxLedgerFramed.png"

import VapeToolLongFramedWebp from "../assets/webp/VapeTool/VapeToolLongFramed.webp"
import GoLureLongFramedWebp from "../assets/webp/GoLure/GoLureLongFramed.webp"
import Wallpapers4KLongFramedWebp from "../assets/webp/Wallpapers4K/Wallpapers4KLongFramed.webp"
import WallpapersOneClickLongFramedWebp from "../assets/webp/WallpapersOneClick/WallpapersOneClickLongFramed.webp"
import WishesLongFramedWebp from "../assets/webp/Wishes/WishesLongFramed.webp"
import TaxLedgerFramedWebp from "../assets/webp/TaxLedger/TaxLedgerFramed.webp"


const Apps: IApp[] = [
  {
    name: "VapeTool",
    href: "https://vapetool.stasbar.com",
    imgSrc: VapeToolLongFramedPng,
    imgWebp: VapeToolLongFramedWebp,
    description: "fully fledged utility arsenal for every Vaper"
  },
  {
    name: "TaxLedger",
    href: "https://tax-ledger.com",
    imgSrc: TaxLedgerFramedPng,
    imgWebp: TaxLedgerFramedWebp,
    description: "desktop application for settle taxes from cryptocurrencies exchanges"
  },
  {
    name: "4K Wallpapers",
    href: "https://play.google.com/store/apps/details?id=com.wallpapers.new_wallpapers4k",
    imgSrc: Wallpapers4KLongFramedPng,
    imgWebp: Wallpapers4KLongFramedWebp,
    description: "4k wallpapers are images in the highest resolutions that have been carefully selected to maximize the screen potential of our phones"
  },
  {
    name: "Go Lure",
    href: "https://play.google.com/store/apps/details?id=com.stasbar.golure",
    imgSrc: GoLureLongFramedPng,
    imgWebp: GoLureLongFramedWebp,
    description: "Schedule Pokemon GO Lure Module Party on a map"
  },
  {
    name: "Wallpapers One Click",
    href: "https://play.google.com/store/apps/details?id=com.david_wallpapers.city_night",
    imgSrc: WallpapersOneClickLongFramedPng,
    imgWebp: WallpapersOneClickLongFramedWebp,
    description: "Just one click, and beautiful landscapes with modern towers and famous skyscrapers will appear on your screen of smartphone"
  },
  {
    name: "Christmas Wishes",
    href: "https://play.google.com/store/apps/details?id=com.allwishes.christmas",
    imgSrc: WishesLongFramedPng,
    imgWebp: WishesLongFramedWebp,
    description: "Christmas Wishes"
  }
];

export default Apps
