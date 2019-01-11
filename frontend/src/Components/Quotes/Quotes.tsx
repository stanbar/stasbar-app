/*
 * Copyright 2019 Stanislaw stasbar Baranski
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

import {Component} from "react";
import {Route, RouteComponentProps} from "react-router";
import {Card, GridList} from "@material-ui/core";
import {Link} from "react-router-dom";
import Api from "../../Api";
import QuoteView from "./QuoteView";
import Quote from "../../Models/Quote";

interface IQuotesProps {

}

interface IQuotesState {
    quotes: Array<Quote>;
}

export default class Quotes extends Component<RouteComponentProps<IQuotesProps>, IQuotesState> {

    public state: IQuotesState = {
        quotes: new Array<Quote>(),
    };


    constructor(props: Readonly<RouteComponentProps<IQuotesProps>>) {
        super(props);
        this.fetchQuotes()
    }

    public render() {
        const {match} = this.props;
        const {quotes} = this.state;
        return (
            <div style={{
                display: 'flex',
                flexWrap: 'wrap',
                justifyContent: 'space-around',
                overflow: 'hidden'
            }}>
                <GridList cols={4} cellHeight={300} style={{width: 800, height: 800}}>
                    {quotes.map((quote: Quote) =>
                        <Link to={`${match.url}/${quote.hash}`}>
                            <Card>

                            </Card>
                        </Link>
                    )}


                </GridList>

                <Route path={`${match.path}/:hash`} component={(props: any) =>
                    <QuoteView {...props}
                               quote={quotes.find((quote: Quote) => quote.hash === props.match.params.hash)}/>
                }/>
            </div>
        );
    }


    private async fetchQuotes() {
        const quotes: Quote[] = await Api.fetchQuotes();
        console.log(quotes);
        this.setState({quotes});
    }
}
