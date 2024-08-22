class ReviewRequestModel {
    rating: number;
    bookId: number;
    reviewDescription?: string;

    constructor(rating: number, bookId: number, revewDescription: string){
       
        this.rating= rating
        this.bookId= bookId;
        this.reviewDescription=revewDescription;
    }
}
export default ReviewRequestModel;